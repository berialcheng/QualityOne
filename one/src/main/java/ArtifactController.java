import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/*")
public class ArtifactController {

	@RequestMapping(method = RequestMethod.GET)
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String releativePath = request.getPathInfo();
		Artifact artifact = CoordinateUtils.resloveCoordinate(releativePath);
		System.out.println(artifact);
	}
}
