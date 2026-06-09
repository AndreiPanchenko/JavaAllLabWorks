package ru.panchenko.geometry;

/**
 * Трёхмерная точка. Расширяет {@link Point}.
 * Класс объявлен как final.
 */
public final class Point3D extends Point {

  private double z;

  /**
   * Конструктор трёхмерной точки.
   * @param x координата X (конечное число)
   * @param y координата Y (конечное число)
   * @param z координата Z (конечное число)
   * @throws IllegalArgumentException если любая координата бесконечна или NaN
   */
  public Point3D(double x, double y, double z) {
    super(x, y);
    if (Double.isNaN(z) || Double.isInfinite(z))
      throw new IllegalArgumentException("Координата Z должна быть конечным числом");
    this.z = z;
  }

  /**
   * Возвращает координату Z.
   * @return значение Z
   */
  public double GetZ() {
    return z;
  }

  /**
   * Устанавливает координату Z.
   * @param z новое значение Z (конечное число)
   * @throws IllegalArgumentException если z бесконечен или NaN
   */
  public void SetZ(double z) {
    if (Double.isNaN(z) || Double.isInfinite(z))
      throw new IllegalArgumentException("Координата Z должна быть конечным числом");
    this.z = z;
  }

  /**
   * Возвращает строковое представление трёхмерной точки.
   * @return строка вида "{x;y;z}"
   */
  @Override
  public String toString() {
    return "{" + GetX() + ";" + GetY() + ";" + z + "}";
  }

  /**
   * Сравнивает текущую трёхмерную точку с другим объектом.
   * @param obj объект для сравнения
   * @return true если объект является точкой Point3D с теми же координатами
   */
  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj)) return false;
    if (obj == null || getClass() != obj.getClass()) return false;
    Point3D point3D = (Point3D) obj;
    return Double.compare(point3D.z, z) == 0;
  }
}