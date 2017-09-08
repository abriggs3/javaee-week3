package edu.matc.week3excercise;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalTime;

public class CustomTag extends SimpleTagSupport {
    String greetingTagContent;

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        getCurrentLocalTime();

        out.println(greetingTagContent);
    }

    public void getCurrentLocalTime() {
        LocalTime time = LocalTime.now();
        int hour = time.getHour();

        if (hour >= 0 & hour <= 11) {
            greetingTagContent = "Good Morning!";
        }
        if (hour >= 12 & hour <= 17) {
            greetingTagContent = "Good Afternoon";
        }
        if (hour >= 18 & hour <= 24) {
            greetingTagContent = "Good Evening";
        }
    }
}
