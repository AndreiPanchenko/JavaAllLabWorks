package ru.panchenko.extended;

/**
 * Абстрактный класс точки как базовый для различных типов точек.
 * Содержит общие координаты x, y и методы доступа к ним.
 */
public abstract class AbstractPoint {
  protected double x;
  protected double y;

  /**
   * Конструктор абстрактной точки.
   * @param x координата X
   * @param y координата Y
   */
  public AbstractPoint(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Возвращает координату X точки.
   * @return значение X
   */
  public double GetX() {
    return x;
  }

  /**
   * Возвращает координату Y точки.
   * @return значение Y
   */
  public double GetY() {
    return y;
  }

  /**
   * Устанавливает координату X точки.
   * @param x новое значение X
   */
  public void SetX(double x) {
    this.x = x;
  }

  /**
   * Устанавливает координату Y точки.
   * @param y новое значение Y
   */
  public void SetY(double y) {
    this.y = y;
  }

  /**
   * Возвращает строковое представление точки.
   * @return строка с координатами
   */
  public abstract String toString();
}