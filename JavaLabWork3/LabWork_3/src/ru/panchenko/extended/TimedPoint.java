package ru.panchenko.extended;

/**
 * Точка с временем появления. Расширяет {@link AbstractPoint}.
 */
public class TimedPoint extends AbstractPoint {

  private String time;

  /**
   * Конструктор точки с временем.
   * @param x координата X
   * @param y координата Y
   * @param time время (не может быть null)
   * @throws IllegalArgumentException если time равен null
   */
  public TimedPoint(double x, double y, String time) {
    super(x, y);
    if (time == null)
      throw new IllegalArgumentException("Время не может быть null");
    this.time = time;
  }

  /**
   * Возвращает время точки.
   * @return время
   */
  public String GetTime() {
    return time;
  }

  /**
   * Устанавливает время точки.
   * @param time новое время (не может быть null)
   * @throws IllegalArgumentException если time равен null
   */
  public void SetTime(String time) {
    if (time == null)
      throw new IllegalArgumentException("Время не может быть null");
    this.time = time;
  }

  /**
   * Возвращает строковое представление точки с временем.
   * @return строка вида "Точка {x;y}, время: время"
   */
  @Override
  public String toString() {
    return "Точка {" + GetX() + ";" + GetY() + "}, время: " + time;
  }
}