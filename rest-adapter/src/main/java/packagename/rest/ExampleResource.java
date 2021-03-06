package packagename.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import packagename.domain.model.Example;
import packagename.domain.model.ExampleInfo;
import packagename.domain.port.RequestExample;

@RestController
@RequestMapping("/api/v1/examples")
public class ExampleResource {

  private RequestExample requestExample;

  public ExampleResource(RequestExample requestExample) {
    this.requestExample = requestExample;
  }

  @GetMapping
  public ResponseEntity<ExampleInfo> getExamples() {
    return ResponseEntity.ok(requestExample.getExamples());
  }

  @GetMapping("/{code}")
  public ResponseEntity<Example> getExampleByCode(@PathVariable Long code) {
    return ResponseEntity.ok(requestExample.getExampleByCode(code));
  }
}
