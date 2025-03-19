package ${{ values.groupId }}.${{ values.artifactId }}.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

@Log4j2
@RestController
@RequestMapping(value = "/rest/hello")
public class Hello {
  
  @GetMapping("/")
  public ResponseEntity<?> hello() {
    log.info("Hello World");
    return ResponseEntity.ok("Hello World");
  }
}
