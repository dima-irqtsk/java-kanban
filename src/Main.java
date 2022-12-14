import manager.InMemoryTaskManager;
import model.Epic;
import model.Status;
import model.SubTask;
import model.Task;


public class Main {

    public static void main(String[] args) {

        System.out.println("Поехали!");
        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();

        Task task1 = new Task("Выгулять собаку", "Бегать, дурачиться и валяться в снегу");
        inMemoryTaskManager.addTask(task1);
        int task1ID = task1.getId();
        System.out.println("Таск №1 добавлен");

        Task task2 = new Task("Вынести мусор", "Надо не забыть собрать всякую мелочь по всей квартире");
        inMemoryTaskManager.addTask(task2);
        System.out.println("Таск №2 добавлен");
        System.out.println("-----------------------------------------------------------------------------------------");

        Epic epic1 = new Epic("Съездить в супермаркет", "Закупиться всяким на месяц");
        inMemoryTaskManager.addEpic(epic1);
        int epic1ID = epic1.getId();
        System.out.println("Пустой эпик №1 добавлен");

        Epic epic2 = new Epic("Убрать лёд с коврика в машине", "А то надоело, что когда жмешь на педали, ноги скользят");
        inMemoryTaskManager.addEpic(epic2);
        int epic2ID = epic2.getId();
        System.out.println("Пустой эпик №2 добавлен");
        System.out.println("-----------------------------------------------------------------------------------------");

        SubTask subTask1 = new SubTask("Купить продукты", "Молоко, сыр, спагетти, яйца", epic1ID);
        inMemoryTaskManager.addSubTask(subTask1);
        int subTask1ID = subTask1.getId();
        System.out.println("Сабтаск №1 к эпику №1 добавлен");

        SubTask subTask2 = new SubTask("Купить бытовую химию", "Таблетки для посудомойки", epic1ID);
        inMemoryTaskManager.addSubTask(subTask2);
        System.out.println("Сабтаск №2 к эпику №1 добавлен");

        SubTask subTask3 = new SubTask("Занести коврик в тепло", "Лучше так, чем на морозе колотить", epic2ID);
        inMemoryTaskManager.addSubTask(subTask3);
        System.out.println("Сабтаск №1 к эпику №2 добавлен");
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Список тасков:");
        for (Integer key : inMemoryTaskManager.getTasks().keySet()) {       // Проходим по ключам в хешмапе тасков
            System.out.println(inMemoryTaskManager.getTask(key));    // Печатаем каждый таск
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Просмотр истории:");
        for (int i = 0; i < inMemoryTaskManager.getHistory().getRequestHistory().size(); i++) {
            System.out.println("№" + (i + 1) + "- id:" + inMemoryTaskManager.getHistory().getRequestHistory().get(i).getId());
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Список эпиков:");
        for (Integer key : inMemoryTaskManager.getEpics().keySet()) {       // Проходим по ключам в хешмапе эпиков
            System.out.println(inMemoryTaskManager.getEpic(key));    // Печатаем каждый эпик
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Просмотр истории:");
        for (int i = 0; i < inMemoryTaskManager.getHistory().getRequestHistory().size(); i++) {
            System.out.println("№" + (i + 1) + "- id:" + inMemoryTaskManager.getHistory().getRequestHistory().get(i).getId());
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Список сабтасков:");
        for (Integer key : inMemoryTaskManager.getSubTasks().keySet()) {       // Проходим по ключам в хешмапе сабтасков
            System.out.println(inMemoryTaskManager.getSubTask(key));    // Печатаем каждый сабтаск
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Получение одного таска по идентификатору:");
        System.out.println(inMemoryTaskManager.getTask(task1ID));
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Получение одного эпика по идентификатору:");
        System.out.println(inMemoryTaskManager.getEpic(epic1ID));
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Получение одного сабтаска по идентификатору:");
        System.out.println(inMemoryTaskManager.getSubTask(subTask1ID));
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Просмотр истории:");
        for (int i = 0; i < inMemoryTaskManager.getHistory().getRequestHistory().size(); i++) {
            System.out.println("№" + (i + 1) + "- id:" + inMemoryTaskManager.getHistory().getRequestHistory().get(i).getId());
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        for (Integer key : inMemoryTaskManager.getTasks().keySet()) {           // Устанавливаем всем таскам статус ЗАВЕРШЕНО
            inMemoryTaskManager.getTask(key).setTaskStatus(Status.DONE);
        }
        System.out.println("Установили статус DONE всем таскам.");

        for (Integer key : inMemoryTaskManager.getEpic(epic1ID).getSubTasksID()) {
            inMemoryTaskManager.updateStatusSubTask(key, Status.DONE);
        }
        System.out.println("Установили статус DONE всем сабтаскам эпика про супермаркет.");
        System.out.println("Статус самого эпика тоже должен быть DONE.");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (Integer key : inMemoryTaskManager.getEpic(epic2ID).getSubTasksID()) {
            inMemoryTaskManager.updateStatusSubTask(key, Status.IN_PROGRESS);
        }
        System.out.println("Установили статус IN_PROGRESS всем сабтаскам эпика про коврик.");
        System.out.println("Статус самого эпика тоже должен быть IN_PROGRESS.");
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Просмотр истории:");
        for (int i = 0; i < inMemoryTaskManager.getHistory().getRequestHistory().size(); i++) {
            System.out.println("№" + (i + 1) + "- id:" + inMemoryTaskManager.getHistory().getRequestHistory().get(i).getId());
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Список тасков:");
        for (Integer key : inMemoryTaskManager.getTasks().keySet()) {       // Проходим по ключам в хешмапе тасков
            System.out.println(inMemoryTaskManager.getTask(key));    // Печатаем каждый таск
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Список эпиков:");
        for (Integer key : inMemoryTaskManager.getEpics().keySet()) {       // Проходим по ключам в хешмапе эпиков
            System.out.println(inMemoryTaskManager.getEpic(key));    // Печатаем каждый эпик
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Список сабтасков:");
        for (Integer key : inMemoryTaskManager.getSubTasks().keySet()) {       // Проходим по ключам в хешмапе сабтасков
            System.out.println(inMemoryTaskManager.getSubTask(key));    // Печатаем каждый сабтаск
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Удаляем один таск");
        inMemoryTaskManager.removeTask(task1ID);
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Удаляем один эпик");
        inMemoryTaskManager.removeEpic(epic1ID);
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Просмотр истории:");
        for (int i = 0; i < inMemoryTaskManager.getHistory().getRequestHistory().size(); i++) {
            System.out.println("№" + (i + 1) + "- id:" + inMemoryTaskManager.getHistory().getRequestHistory().get(i).getId());
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Список тасков:");
        for (Integer key : inMemoryTaskManager.getTasks().keySet()) {       // Проходим по ключам в хешмапе тасков
            System.out.println(inMemoryTaskManager.getTask(key));    // Печатаем каждый таск
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Список эпиков:");
        for (Integer key : inMemoryTaskManager.getEpics().keySet()) {       // Проходим по ключам в хешмапе эпиков
            System.out.println(inMemoryTaskManager.getEpic(key));    // Печатаем каждый эпик
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Список сабтасков:");
        for (Integer key : inMemoryTaskManager.getSubTasks().keySet()) {       // Проходим по ключам в хешмапе сабтасков
            System.out.println(inMemoryTaskManager.getSubTask(key));    // Печатаем каждый сабтаск
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Очищаем список сабтасков");
        inMemoryTaskManager.clearSubTasks();
        System.out.println("У эпиков должен быть статус NEW");
        System.out.println("Список эпиков:");
        for (Integer key : inMemoryTaskManager.getEpics().keySet()) {       // Проходим по ключам в хешмапе эпиков
            System.out.println(inMemoryTaskManager.getEpics().get(key));    // Печатаем каждый эпик
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Очищаем список эпиков");
        inMemoryTaskManager.clearEpics();
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Очищаем список тасков");
        inMemoryTaskManager.clearTasks();
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Список тасков:");
        for (Integer key : inMemoryTaskManager.getTasks().keySet()) {       // Проходим по ключам в хешмапе тасков
            System.out.println(inMemoryTaskManager.getTask(key));    // Печатаем каждый таск
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Список эпиков:");
        for (Integer key : inMemoryTaskManager.getEpics().keySet()) {       // Проходим по ключам в хешмапе эпиков
            System.out.println(inMemoryTaskManager.getEpic(key));    // Печатаем каждый эпик
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Список сабтасков:");
        for (Integer key : inMemoryTaskManager.getSubTasks().keySet()) {       // Проходим по ключам в хешмапе сабтасков
            System.out.println(inMemoryTaskManager.getSubTask(key));    // Печатаем каждый сабтаск
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Просмотр истории:");
        for (int i = 0; i < inMemoryTaskManager.getHistory().getRequestHistory().size(); i++) {
            System.out.println("№" + (i + 1) + "- id:" + inMemoryTaskManager.getHistory().getRequestHistory().get(i).getId());
        }

        System.out.println("-----------------------------------------------------------------------------------------");
    }

}
