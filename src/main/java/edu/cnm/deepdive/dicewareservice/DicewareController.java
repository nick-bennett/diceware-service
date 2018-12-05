package edu.cnm.deepdive.dicewareservice;

import edu.cnm.deepdive.cryptography.ArtifactGenerator;
import edu.cnm.deepdive.cryptography.PassphraseGenerator;
import edu.cnm.deepdive.cryptography.WordSource;
import java.util.Random;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DicewareController {

  private ArtifactGenerator generator;

  public DicewareController(WordSource source, Random rng) {
    generator = new PassphraseGenerator(source, rng);
  }

  @GetMapping(path = "/diceware", produces = MediaType.TEXT_PLAIN_VALUE)
  public String get(
      @RequestParam(name = "length", defaultValue = "6", required = false) int length) {
    return generator.generate(length);
  }

  @GetMapping(path = "/diceware", produces = MediaType.APPLICATION_JSON_VALUE)
  public String[] getJson(
      @RequestParam(name = "length", defaultValue = "6", required = false) int length) {
    return get(length).split("\\s+");
  }

}
