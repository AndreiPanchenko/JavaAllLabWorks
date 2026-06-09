package ru.panchenko.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс ломаной линии, состоящей из последовательности точек.
 */
public class Polyline {

  private List<Point> points;

  /**
   * Конструктор по умолчанию – создаёт пустую ломаную.
   */
  public Polyline() {
    this.points = new ArrayList<>();
  }

  /**
   * Конструктор с массивом точек.
   * @param points массив точек (не может быть null, элементы не могут быть null)
   * @throws IllegalArgumentException если массив точек равен null или какой-либо элемент null
   */
  public Polyline(Point... points) {
    this.points = new ArrayList<>();
    if (points == null)
      throw new IllegalArgumentException("Массив точек не может быть null");
    for (Point p : points) {
      if (p == null)
        throw new IllegalArgumentException("Точки в массиве не могут быть null");
      this.points.add(new Point(p.GetX(), p.GetY()));
    }
  }

  /**
   * Добавляет новые точки в конец ломаной.
   * @param newPoints массив добавляемых точек (не может быть null)
   * @throws IllegalArgumentException если массив newPoints равен null или какой-либо элемент null
   */
  public void AddPoints(Point... newPoints) {
    if (newPoints == null)
      throw new IllegalArgumentException("Массив новых точек не может быть null");
    for (Point p : newPoints) {
      if (p == null)
        throw new IllegalArgumentException("Точки в массиве не могут быть null");
      points.add(new Point(p.GetX(), p.GetY()));
    }
  }

  /**
   * Возвращает копию списка точек ломаной.
   * @return новый список, содержащий копии всех точек
   */
  public List<Point> GetPoints() {
    List<Point> copy = new ArrayList<>();
    for (Point p : points) {
      Point pointCopy = new Point(p.GetX(), p.GetY());
      copy.add(pointCopy);
    }
    return copy;
  }

  /**
   * Вычисляет общую длину ломаной (сумму длин всех отрезков).
   * @return длина ломаной (0, если точек меньше двух)
   */
  public double GetLength() {
    if (points.size() < 2)
      return 0;
    double totalLength = 0;
    for (int i = 0; i < points.size() - 1; i++) {
      Line segment = new Line(points.get(i), points.get(i + 1));
      totalLength += segment.GetLength();
    }
    return totalLength;
  }

  /**
   * Возвращает строковое представление ломаной.
   * @return строка вида "Ломаная линия [точки]"
   */
  @Override
  public String toString() {
    return "Ломаная линия " + points;
  }
}