package wieczorek.jakub.calendar.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by jakub on 20.05.17.
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class<?> [] {RootCalendarConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {

        return new Class [] {CalendarConfiguration.class};
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String [] {"/"};
    }
}
