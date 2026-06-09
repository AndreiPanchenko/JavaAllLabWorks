//Класс, представляющий пистолет
//Имеет количество патронов и умеет стрелять

public class Gun {
  private int bullets;

  // Конструктор по умолчанию — пистолет заряжен 5 патронами
  public Gun() {
    this.bullets = 5;
  }

  // Конструктор с указанием начального количества патронов(bullets)
  public Gun(int bullets) {
    this.bullets = bullets;
  }

  // Выстрел: если патроны есть — выводит "Бах!", иначе — "Клац!"
  // После успешного выстрела количество патронов уменьшается на 1

  public void shoot() {
    if (bullets > 0) {
      System.out.println("Бах!");
      bullets--;
    } else {
      System.out.println("Клац!");
    }
  }

  public int getBullets() {
    return bullets;
  }

  @Override
  public String toString() {
    return "Пистолет с " + bullets + " патронами";
  }
}