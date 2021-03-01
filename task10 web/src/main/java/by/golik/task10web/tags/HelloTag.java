package by.golik.task10web.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * @author Nikita Golik
 */
public class HelloTag extends TagSupport {
   private String username;
   private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int doStartTag() throws JspException {
        String welcomeMessage = "Hello, " + getUsername() + " your role is " + getRole();
        try {
            pageContext.getOut().write("<div>" + welcomeMessage + "</div>");
        } catch (IOException e) {
            throw  new JspException();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
