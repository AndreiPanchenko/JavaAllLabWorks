package ru.panchenko.geometry;

/**
 * Класс точки на двумерной плоскости.
 */
public class Point {
  private double x;
  private double y;

  /**
   * Конструктор точки.
   * @param x координата X (конечное число)
   * @param y координата Y (конечное число)
   * @throws IllegalArgumentException если x или y бесконечны или NaN
   */
  public Point(double x, double y) {
    if (Double.isNaN(x) || Double.isInfinite(x))
      throw new IllegalArgumentException("Координата X должна быть конечным числом");
    if (Double.isNaN(y) || Double.isInfinite(y))
      throw new IllegalArgumentException("Координата Y должна быть конечным числом");
    this.x = x;
    this.y = y;
  }

  /**
   * Возвращает координату X.
   * @return значение X
   */
  public double GetX() {
    return x;
  }

  /**
   * Возвращает координату Y.
   * @return значение Y
   */
  public double GetY() {
    return y;
  }

  /**
   * Устанавливает координату X.
   * @param x новое значение X (конечное число)
   * @throws IllegalArgumentException если x бесконечен или NaN
   */
  public void SetX(double x) {
    if (Double.isNaN(x) || Double.isInfinite(x))
      throw new IllegalArgumentException("Координата X должна быть конечным числом");
    this.x = x;
  }

  /**
   * Устанавливает координату Y.
   * @param y новое значение Y (конечное число)
   * @throws IllegalArgumentException если y бесконечен или NaN
   */
  public void SetY(double y) {
    if (Double.isNaN(y) || Double.isInfinite(y))
      throw new IllegalArgumentException("Координата Y должна быть конечным числом");
    this.y = y;
  }

  /**
   * Возвращает строковое представление точки.
   * @return строка вида "{x;y}"
   */
  @Override
  public String toString() {
    return "{" + x + ";" + y + "}";
  }

  /**
   * Сравнивает текущую точку с другим объектом.
   * @param obj объект для сравнения
   * @return true если объект является точкой с такими же координатами
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Point point = (Point) obj;
    return Double.compare(point.x, x) == 0 &&
        Double.compare(point.y, y) == 0;
  }
}