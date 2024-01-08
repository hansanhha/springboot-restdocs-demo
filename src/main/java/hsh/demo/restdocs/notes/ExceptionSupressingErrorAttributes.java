package hsh.demo.restdocs.notes;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class ExceptionSupressingErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);

        errorAttributes.remove("exception");

        Object message = webRequest.getAttribute("javax.servlet.error.message", RequestAttributes.SCOPE_REQUEST);

        if (message != null) {
            errorAttributes.put("message", message);
        }

        return errorAttributes;
    }
}
