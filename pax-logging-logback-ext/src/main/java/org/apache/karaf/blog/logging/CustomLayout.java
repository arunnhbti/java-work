package org.apache.karaf.blog.logging;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;

public class CustomLayout extends LayoutBase
{

    @Override
    public String doLayout(Object parEvent)
    {
        return "Sensitive == " + parEvent.toString() + CoreConstants.LINE_SEPARATOR;
    }

}
