#!/usr/bin/python2.7

import sys, getopt, csv
class TableCreater:
	def __init__(self, argv):
		self.inputFile = None
		self.outputFile = None
		self.loader = None
		self.csv = None
		self.entityFile = None
		self.converterFile = None
		self.dtoFile = None		


		self.columnWithName = 9
		self.columnWithLength = 8
		self.columnWithComment = 1
		self.columnWithFlag = 5
		self.columnWithDateFlag = 10

		self.argv = argv	
	
	def showHelp(self):
		helpString = 'type:\n'
		helpString += '$ python -i fileWithTableDescription.csv -o outputFileWithSqlTable.sql to create sql table from csv file. Open this file and check the contents of __init__ method to check how prepare csv file.\n'
		helpString += 'above flags is necessary !\n'
		helpString += 'with above flags type:\n'
		helpString += '-l outputSqlldrFile.ctl -c csvInputFileWithDataToFulfillTheTable.csv - this flags must occur together.\n'
		helpString += '-j - to create java template classes.\n'
		helpString += '-h to print this help\n'
		
		print helpString		
	
	def parseArgs(self):
		
		try:
			opts, args = getopt.getopt(self.argv, "hi:l:c:jo:", ["help", "input=", "loader=", "csv=", "java", "output="])
		except getopt.GetoptError:
			print 'python alpha.py -i <inputfile with table specification> -l <outputfile loader> -c <sql data in csv> -j -o <sql output>'
			sys.exit(2)
		
		for opt, arg in opts:
			if opt in ('-i', '--input'):
				self.inputFile = arg
			elif opt in ('-o', '--output'):
				self.outputFile = arg
			elif opt in ('-l', '--loader'):
				self.loader = arg
			elif opt in ('-c', '--csv'):
				self.csv = arg
			elif opt in ('-j', '--java'):
				self.entityFile = 'Entity.java'
				self.converterFile = 'Converter.java'
				self.dtoFile = 'Dto.java'
			elif opt in ('-h', '--help'):
				self.showHelp()
				sys.exit(2)

		self.createFiles()
		
	def createFiles(self):
		
		if(self.inputFile != None and self.outputFile != None):
			self.createSql()
		
		if(self.loader != None and self.csv != None):
			self.createControlFile()
		
		if(self.entityFile != None):
			self.createEntityFile()
		
		if(self.converterFile != None):
			self.createConvertFile()
		
		if(self.dtoFile != None):
			self.createDtoFile()

	def createSql(self):
		
		tablename = self.outputFile.split('.')
		self.tablename = tablename[0]
		self.outputFile = open(self.outputFile, 'w') # the same as in C, open file with privilage
		
		comment = ''
		sqlContent = ''

		self.reader = csv.reader(open(self.inputFile, "rU"), delimiter = ';')

		sqlContent += 'CREATE TABLE {0} (\n'.format(self.tablename)
			
		for row in self.reader:
			comment = comment + 'COMMENT ON COLUMN {0}.'.format(self.tablename) + row[self.columnWithName] + ' IS \'' + row[self.columnWithComment] + '\';\n'		
			if row[self.columnWithDateFlag] == 'D': #data
				sqlContent += '{0} DATE, \n'.format(row[self.columnWithName])
			else:
				if row[self.columnWithFlag] == 'A': #alphanumeric
					sqlContent += '{0} VARCHAR2({1}),\n'.format(row[self.columnWithName], row[self.columnWithLength])

				elif row[self.columnWithFlag] == 'N': # number

					if ' ' in row[self.columnWithLength]: # number with fractional part
						values = row[self.columnWithLength].split()
						
						values[0] = int(values[0])
						values[1] = int(values[1])
						
						values[0] += values[1]
						
						values[0] = str(values[0])
						values[1] = str(values[1])
						
						sqlContent += '{0} NUMBER({1}),\n'.format(row[self.columnWithName], values[0] + ', ' + values[1])
					else: # number without fractional part
						sqlContent += '{0} NUMBER({1}),\n'.format(row[self.columnWithName], row[self.columnWithLength])
		
		sqlContent = sqlContent[:-2]	
		sqlContent +=  '\n);'
		
		print >> self.outputFile, sqlContent
		
		self.createComment(comment)
	
	def createComment(self, comment):
		[header, content] = comment.split('\n', self.columnWithComment)
		print >> self.outputFile,  content
				
		self.outputFile.close()

	def createControlFile(self):	
		
		self.reader = csv.reader(open(self.inputFile, "rU"), delimiter = ';')

		self.loader = open(self.loader, 'w') # the same as in C, open file with privilage	
		loaderContent = ''

		loaderContent += 'LOAD DATA INFILE \'{0}\'\nINTO TABLE {1}\nFIELDS TERMINATED BY \';\' OPTIONALLY ENCLOSED BY \'"\'\nTRAILING NULLCOLS\n(\n'.format(self.csv, self.tablename)
		
		for row in self.reader:			
			if row[self.columnWithDateFlag] == 'D': #date
				loaderContent += '{0} \"TO_DATE(DECODE(TRIM(:{0}), 0, NULL, TRIM(:{0})), \'yyyyMMdd\')\",\n'.format(row[self.columnWithName], row[self.columnWithName])
			else:
				if row[self.columnWithFlag] == 'A': #alphanumeric
					loaderContent += '{0} NULLIF {0}=BLANKS "TRIM(:{0})",\n'.format(row[self.columnWithName])

				elif row[self.columnWithFlag] == 'N': # number
					loaderContent += '{0} NULLIF {0}=BLANKS "TRIM(:{0})",\n'.format(row[self.columnWithName])

		loaderContent = loaderContent[:-2]
		loaderContent += '\n)'
		
		print >> self.loader, loaderContent

		self.loader.close()
	
	def createEntityFile(self):
		self.reader = csv.reader(open(self.inputFile, "rU"), delimiter = ";")

		self.entityFile = open(self.entityFile, "w")
		entityContent = ''

		entityContent += '@Entity\n@Table(name = "' + self.tablename  + '")\npublic class Entity\n{\n'
		
		for row in self.reader:
			if row[self.columnWithDateFlag] == 'D': #date
				entityContent += '\t@Column(name = "{0}")\n'.format(row[self.columnWithName])
				entityContent += '\tprivate Date {0};\n\n'.format(row[self.columnWithName])
			else:
				if row[self.columnWithFlag] == 'A': #alphanumeric
					entityContent += '\t@Column(name = "{0}")\n'.format(row[self.columnWithName])
					entityContent += '\tprivate String {0};\n\n'.format(row[self.columnWithName])

				elif row[self.columnWithFlag] == 'N': # number
					if ' ' in row[self.columnWithLength]: # number with fractional part
						entityContent += '\t@Column(name = "{0}")\n'.format(row[self.columnWithName])
						entityContent += '\tprivate BigDecimal {0};\n\n'.format(row[self.columnWithName])
				
					else: # number without fractional part
						entityContent += '\t@Column(name = "{0}")\n'.format(row[self.columnWithName])
						entityContent += '\tprivate Long {0};\n\n'.format(row[self.columnWithName])
			 
		
		
		entityContent += '}'
		
		print >> self.entityFile, entityContent		
		
	def createConvertFile(self):
		self.reader = csv.reader(open(self.inputFile, "rU"), delimiter = ";")

		self.converterFile = open(self.converterFile, "w")
		convertContent = ''

		convertContent += 'public class Converter\n{\n'
		
		convertContent += '\tpublic convert\n\t{'
		
		for row in self.reader:
			convertContent += '\t\t dto.set{0}(entity.get{0}());\n\n'.format(row[self.columnWithName])
		
		
		convertContent += '\t}\n}'
		
		print >> self.converterFile, convertContent		
	
	def createDtoFile(self):
		self.reader = csv.reader(open(self.inputFile, "rU"), delimiter = ";")

		self.dtoFile = open(self.dtoFile, "w")
		dtoContent = ''

		dtoContent += 'public class Dto\n{\n'
		
		for row in self.reader:
			if row[self.columnWithDateFlag] == 'D': #date
				dtoContent += '\tprivate Date {0};\n\n'.format(row[self.columnWithName])
			else:
				if row[self.columnWithFlag] == 'A': #alphanumeric
					dtoContent += '\tprivate String {0};\n\n'.format(row[self.columnWithName])

				elif row[self.columnWithFlag] == 'N': # number
					if ' ' in row[self.columnWithLength]: # number with fractional part
						dtoContent += '\tprivate BigDecimal {0};\n\n'.format(row[self.columnWithName])
				
					else: # number without fractional part
						dtoContent += '\tprivate Long {0};\n\n'.format(row[self.columnWithName])
			 
		
		
		dtoContent += '}'
		
		print >> self.dtoFile, dtoContent		
	
	def create(self):
		self.parseArgs()

if __name__ == '__main__':
	creater = TableCreater(sys.argv[1:])

	creater.create()
