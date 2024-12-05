public class ArrayList {
    private int[] items;
    private int count;

    public ArrayList(int size) {
        items = new int[size];
        count = 0;
    }

    public ArrayList() {
        this(10);
    }

    public void setItems(int[] items) {
        this.items = items;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int[] getItems() {
        return items;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public void shiftRight(int location) {
        int pos = count;
        while (pos > location)
            items[pos] = items[--pos];
    }

    public void doubleTheArray() {
        int[] temp = new int[items.length * 2];
        for (int i = 0; i < count; i++)
            temp[i] = items[i];
        items = temp;
    }

    public void addFront(int item) {
        if (isFull())
            doubleTheArray();
        if (!isEmpty())
            shiftRight(0);

        items[0] = item;
        count++;
    }

    public void insertItemAt(int item, int pos) {
        if (isFull())
            doubleTheArray();
        if (pos >= 0 && pos <= count) {
            if (pos == 0)
                addFront(item);
            else if (pos == count)
                addLast(item);
            else {
                shiftRight(pos);
                items[pos] = item;
            }
            count++;
        }
    }

    public void addLast(int item) {
        if (isFull())
            doubleTheArray();
        items[count] = item;
        count++;
    }

    private void shiftLeft(int location) {
        int pos = location;
        while (pos < count - 1)
            items[pos] = items[++pos];
    }

    public void removeFirst() {
        if (!isEmpty()) {
            shiftLeft(0);
            count--;
        }
    }

    public void removeLast() {
        if (!isEmpty()) {
            count--;
            items[count] = 0;
        }
    }

    public void removeItemAt(int pos) {
        if (pos >= 0 && pos < count) {
            for (int i = pos; i < count - 1; i++) {
                items[i] = items[i + 1];
            }
            count--;
        }
    }

    public int getPosition(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public boolean isFound(int item) {
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < count; i++)
            sb.append(items[i] + " ");
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.addFront(5);
        list.addFront(6);
        list.addFront(8);
        list.addFront(9);

        System.out.println("There are " + list.count + " number of elements");
        System.out.println("The list contains: " + list);

        list.insertItemAt(10, 2);
        System.out.println("The list contains: " + list);

        System.out.println("The item 4 is " + list.isFound(4));

        list.removeFirst();
        System.out.println("The list contains: " + list);
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        System.out.println("The list contains: " + list);

        list.addLast(4);
        list.addLast(7);
        list.addLast(1);
        System.out.println("There are " + list.count + " number of elements");
        System.out.println("The list contains: " + list);

        if (list.isFound(7)) {
            list.removeItemAt(list.getPosition(7));
            System.out.println("Item 7 is removed: " + list);
        } else {
            System.out.println("Item 7 is not found.");
        }

        int positionOf9 = list.getPosition(9);
        System.out.println("The position of number 9 is: " + positionOf9);
    }
}