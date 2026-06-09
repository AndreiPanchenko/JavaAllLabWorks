package ru.panchenko.geometry;

/**
 * Класс линии на плоскости. Реализует {@link Cloneable}.
 */
public class Line implements Cloneable {

  private Point start;
  private Point end;

  /**
   * Конструктор линии по объектам точек.
   * @param start точка начала (не может быть null)
   * @param end точка конца (не может быть null)
   * @throws IllegalArgumentException если start или end равен null, либо точки совпадают
   */
  public Line(Point start, Point end) {
    if (start == null || end == null)
      throw new IllegalArgumentException("Точки начала и конца не могут быть null");
    if (start.equals(end))
      throw new IllegalArgumentException("Точки начала и конца не могут совпадать");
    this.start = new Point(start.GetX(), start.GetY());
    this.end = new Point(end.GetX(), end.GetY());
  }

  /**
   * Конструктор линии по координатам.
   * @param x1 координата X начала
   * @param y1 координата Y начала
   * @param x2 координата X конца
   * @param y2 координата Y конца
   * @throws IllegalArgumentException если точки совпадают
   */
  public Line(double x1, double y1, double x2, double y2) {
    if (x1 == x2 && y1 == y2)
      throw new IllegalArgumentException("Точки начала и конца не могут совпадать");
    this.start = new Point(x1, y1);
    this.end = new Point(x2, y2);
  }

  /**
   * Возвращает копию точки начала линии.
   * @return новая точка с координатами начала
   */
  public Point GetStart() {
    return new Point(start.GetX(), start.GetY());
  }

  /**
   * Возвращает копию точки конца линии.
   * @return новая точка с координатами конца
   */
  public Point GetEnd() {
    return new Point(end.GetX(), end.GetY());
  }

  /**
   * Устанавливает новую точку начала линии.
   * @param start новая точка начала (не может быть null)
   * @throws IllegalArgumentException если start равен null
   */
  public void SetStart(Point start) {
    if (start == null)
      throw new IllegalArgumentException("Точка начала не может быть null");
    this.start = new Point(start.GetX(), start.GetY());
  }

  /**
   * Устанавливает новую точку конца линии.
   * @param end новая точка конца (не может быть null)
   * @throws IllegalArgumentException если end равен null
   */
  public void SetEnd(Point end) {
    if (end == null)
      throw new IllegalArgumentException("Точка конца не может быть null");
    this.end = new Point(end.GetX(), end.GetY());
  }

  /**
   * Возвращает длину линии (целая часть).
   * @return длина линии, округлённая вниз до целого
   */
  public int GetLength() {
    double dx = end.GetX() - start.GetX();
    double dy = end.GetY() - start.GetY();
    return (int) Math.sqrt(dx * dx + dy * dy);
  }

  /**
   * Сравнивает текущую линию с другим объектом.
   * @param obj объект для сравнения
   * @return true если объект является линией и имеет совпадающие начало и конец
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Line line = (Line) obj;
    return start.equals(line.start) && end.equals(line.end);
  }

  /**
   * Создаёт и возвращает глубокую копию линии.
   * @return клон линии
   * @throws RuntimeException если клонирование не поддерживается (не происходит)
   */
  @Override
  public Line clone() {
    try {
      Line cloned = (Line) super.clone();
      cloned.start = new Point(start.GetX(), start.GetY());
      cloned.end = new Point(end.GetX(), end.GetY());
      return cloned;
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException("Ошибка клонирования линии", e);
    }
  }

  /**
   * Возвращает строковое представление линии.
   * @return строка вида "Линия от {x;y} до {x;y}"
   */
  @Override
  public String toString() {
    return "Линия от " + start + " до " + end;
  }
}