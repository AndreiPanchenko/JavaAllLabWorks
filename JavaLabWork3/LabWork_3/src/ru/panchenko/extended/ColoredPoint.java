package ru.panchenko.extended;

/**
 * Точка с цветом. Расширяет {@link AbstractPoint}.
 */
public class ColoredPoint extends AbstractPoint {

  private String color;

  /**
   * Конструктор цветной точки.
   * @param x координата X
   * @param y координата Y
   * @param color цвет точки (не может быть null)
   * @throws IllegalArgumentException если color равен null
   */
  public ColoredPoint(double x, double y, String color) {
    super(x, y);
    if (color == null)
      throw new IllegalArgumentException("Цвет не может быть null");
    this.color = color;
  }

  /**
   * Возвращает цвет точки.
   * @return цвет
   */
  public String GetColor() {
    return color;
  }

  /**
   * Устанавливает цвет точки.
   * @param color новый цвет (не может быть null)
   * @throws IllegalArgumentException если color равен null
   */
  public void SetColor(String color) {
    if (color == null)
      throw new IllegalArgumentException("Цвет не может быть null");
    this.color = color;
  }

  /**
   * Возвращает строковое представление цветной точки.
   * @return строка вида "Точка {x;y}, цвет: цвет"
   */
  @Override
  public String toString() {
    return "Точка {" + GetX() + ";" + GetY() + "}, цвет: " + color;
  }
}