package chapter15practices;

import java.util.*;

public class Generated16 {
  // Fill an existing array:
   public static <T> T[] array(T[] a, SkipGenerator<T> gen, int skip) {
    return new CollectionData16<T>(gen, skip, a.length).toArray(a);
  }
} 

class CollectionData16<T> extends ArrayList<T> {
  public CollectionData16(SkipGenerator<T> gen, int skip, int quantity) {
    for(int i = 0; i < quantity; i++)
      add(gen.next(skip));
  }
}
