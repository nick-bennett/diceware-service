package edu.cnm.deepdive.cryptography;

@FunctionalInterface
public interface ArtifactGenerator {

  String generate(int length);

}
