package wieczorek.jakub.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import wieczorek.jakub.calendar.boundry.UserService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * Created by jakub on 08.07.17.
 */
@Service
public class EJBFactory
{
    private static final Logger LOG = LoggerFactory.getLogger(EJBFactory.class);
    private static final String REMOTE_URL = null;//System.getenv("");

    @Bean(name = "userService")
    public UserService createUserService()
    {
        return getObj(UserService.class, null);
    }

    private <T> T getObj(Class<T> clazz, String ejbName)
    {
        if (StringUtils.hasLength(REMOTE_URL))
        {
            if (StringUtils.hasLength(ejbName))
            {
                return lookup(clazz, ejbName, REMOTE_URL);
            } else
            {
                return lookup(clazz, REMOTE_URL);
            }
        }

        return lookup(clazz);
    }

    private <T> T lookup(Class<T> clazz)
    {
        try
        {
            Context context = new InitialContext();
            return (T) context.lookup(clazz.getName());
        } catch (Exception exc)
        {
            LOG.error("JNDI lookup error", exc);
            throw new RuntimeException(exc);
        }
    }

    private <T> T lookup(Class<T> clazz, String aEJBName, String aURL)
    {
        try
        {
            Properties props = new Properties();
            props.put(Context.PROVIDER_URL, aURL);
            Object lobj;
            InitialContext ctx;
            ctx = new InitialContext(props);
            lobj = ctx.lookup(aEJBName);
            return (T) PortableRemoteObject.narrow(lobj, clazz);
        } catch (Exception exc)
        {
            LOG.error(MessageFormat.format("JNDI lookup error for object [{0}], URL [{1}]", aEJBName, aURL), exc);
            throw new RuntimeException(exc);
        }
    }

    private <T> T lookup(Class<T> clazz, String aURL)
    {
        return lookup(clazz, clazz.getName(), aURL);
    }
}
