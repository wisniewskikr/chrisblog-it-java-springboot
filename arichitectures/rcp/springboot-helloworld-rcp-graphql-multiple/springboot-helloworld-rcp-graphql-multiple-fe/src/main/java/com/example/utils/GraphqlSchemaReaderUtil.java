package com.example.utils;

import java.io.IOException;

public final class GraphqlSchemaReaderUtil {

  public static String getSchemaFromFileName(final String filename) throws IOException {
    return new String(
        GraphqlSchemaReaderUtil.class.getClassLoader().getResourceAsStream("graphql/" + filename + ".graphql").readAllBytes());

  }

}
