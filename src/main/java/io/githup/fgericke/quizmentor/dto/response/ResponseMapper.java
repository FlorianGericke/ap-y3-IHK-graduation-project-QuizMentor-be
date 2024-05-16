package io.githup.fgericke.quizmentor.dto.response;

/**
 * This is a functional interface that represents a generic mapper. It's designed to convert or map
 * one type of object (I) into another type of object (R). This interface is used throughout the
 * application wherever a conversion between two types is needed.
 *
 * @param <I> the type of input object to be mapped
 * @param <R> the type of result object after mapping
 */
@FunctionalInterface
public interface ResponseMapper<I, R> {

  /**
   * This method is used to map or convert an object of type I into an object of type R.
   *
   * @param input the object of type I to be converted
   * @return the converted object of type R
   */
  R mapToResponse(final I input);


  /**
   * This method is used to map or convert an object of type I into an object of type R. It is a
   * default method that returns null if the input object is null.
   *
   * @param input the object of type I to be converted
   * @return the converted object of type R
   */
  default R map(final I input) {
    return input == null ? null : mapToResponse(input);
  }
}
