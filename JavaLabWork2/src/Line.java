// Класс, представляющий линию на двумерной плоскости
// Состоит из двух точек: начало и конец

public class Line {
  // Приватные поля для начала и конца линии
  private Point start;
  private Point end;

  // Конструктор линии с заданными начальной(start) и конечной(end) точками
  public Line(Point start, Point end) {
    this.start = start;
    this.end = end;
  }

  // Геттеры и сеттеры для точек
  public Point getStart() {
    return start;
  }

  public Point getEnd() {
    return end;
  }

  public void setStart(Point start) {
    this.start = start;
  }

  public void setEnd(Point end) {
    this.end = end;
  }

  // Возвращает строковое представление линии в формате:
  // "Линия от {X1;Y1} до {X2;Y2}"

  @Override
  public String toString() {
    return "Линия от " + start + " до " + end;
  }
}