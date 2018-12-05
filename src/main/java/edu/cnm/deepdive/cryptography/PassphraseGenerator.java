package edu.cnm.deepdive.cryptography;

import java.util.Random;

public class PassphraseGenerator implements ArtifactGenerator {

  private WordSource source;
  private Random rng;

  public PassphraseGenerator(WordSource source, Random rng) {
    this.source = source;
    this.rng = rng;
  }

  @Override
  public String generate(int length) {
    StringBuilder builder = new StringBuilder();
    int size = source.size();
    for (int i = 0; i < length; i++) {
      builder
          .append(source.get(rng.nextInt(size)))
          .append(' ');
    }
    return builder.substring(0, builder.length() - 1);
  }

}
