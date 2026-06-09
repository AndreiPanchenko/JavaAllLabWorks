package ru.panchenko.collections;

import java.util.Arrays;

/**
 * Неизменяемый список целых чисел.
 * Любая операция изменения возвращает новый список.
 */
public class ImmutableList {

  private final int[] values;

  /**
   * Конструктор из массива значений.
   * @param values массив целых чисел (не может быть null)
   * @throws IllegalArgumentException если values равен null или какой-либо элемент не является целым
   */
  public ImmutableList(int... values) {
    if (values == null)
      throw new IllegalArgumentException("Массив не может быть null");
    for (int i = 0; i < values.length; i++) {
      if (values[i] != (int) values[i])
        throw new IllegalArgumentException("Элемент с индексом " + i + " не является целым числом: " + values[i]);
    }
    this.values = Arrays.copyOf(values, values.length);
  }

  /**
   * Конструктор копирования.
   * @param other другой список (не может быть null)
   * @throws IllegalArgumentException если other равен null
   */
  public ImmutableList(ImmutableList other) {
    if (other == null)
      throw new IllegalArgumentException("Другой список не может быть null");
    this.values = Arrays.copyOf(other.values, other.values.length);
  }

  /**
   * Возвращает элемент по индексу.
   * @param index индекс (0-based)
   * @return значение элемента
   * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
   */
  public int Get(int index) {
    if (index < 0 || index >= values.length)
      throw new IndexOutOfBoundsException(
          "Индекс " + index + " вне границ [0, " + (values.length - 1) + "]"
      );
    return values[index];
  }

  /**
   * Создаёт новый список с заменой одного элемента.
   * @param index индекс заменяемого элемента
   * @param value новое значение
   * @return новый список
   * @throws IndexOutOfBoundsException если индекс вне диапазона
   * @throws IllegalArgumentException если новое значение не целое (не требуется, но оставлено для совместимости)
   */
  public ImmutableList Set(int index, int value) {
    if (index < 0 || index >= values.length)
      throw new IndexOutOfBoundsException(
          "Индекс " + index + " вне границ [0, " + (values.length - 1) + "]"
      );
    if (value != (int) value)
      throw new IllegalArgumentException("Новое значение не является целым числом: " + value);
    int[] newValues = Arrays.copyOf(values, values.length);
    newValues[index] = value;
    return new ImmutableList(newValues);
  }

  /**
   * Проверяет, пуст ли список.
   * @return true если список не содержит элементов
   */
  public boolean IsEmpty() {
    return values.length == 0;
  }

  /**
   * Возвращает количество элементов в списке.
   * @return размер списка
   */
  public int Size() {
    return values.length;
  }

  /**
   * Возвращает копию внутреннего массива значений.
   * @return новый массив, содержащий все элементы списка
   */
  public int[] ToArray() {
    return Arrays.copyOf(values, values.length);
  }

  /**
   * Возвращает строковое представление списка.
   * @return строка вида [элемент1, элемент2, ...]
   */
  @Override
  public String toString() {
    return Arrays.toString(values);
  }
}