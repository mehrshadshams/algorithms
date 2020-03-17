package com.mshams.cs.problems.legacy;

public class Main {

  public static void main(String[] args) {
//        int[] array = new int[] { 8, 2, 9, 3, 1, 5, 4, 6 };
//        mergeSort(array);
//        for (int i=0; i<array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.println("");
//        array = new int[10];

//        int[] numbers = new int[] { 5, 10, 9, 6, 7, 11, 15, 12, 19, 17, 22 };
//        int[] numbers = new int[] { 4, 10, 8, 7, 6, 5, 3, 12, 14, 2 };
////        int[] numbers = new int[] { 5, 6, 7, 9, 10, 11, 15, 12, 19, 17, 22 };
//
//        PriorityQueue<Integer> p = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
//        Arrays.stream(numbers).boxed().collect(Collectors.toList()).forEach(p::add);
//
//        while (p.peek() != null) {
//            System.out.print(p.remove() + " ");
//        }

//        quick_sort(numbers, 0, numbers.length - 1);
//
//        ArrayList a;
//        a.sort();
//
//        for (int i=0; i<numbers.length; i++) {
//            System.out.println(numbers[i]);
//        }

//        Heap heap = new Heap(numbers);
//        for (int x : numbers) {
//            heap.add(x);
//        }
//        heap.print();
//
//        while (heap.position > 0) {
//            heap.remove();
//        }
//        heap.print();


//        Tree t = new Tree();
//        for (int i : numbers) {
//            t.add(i);
//        }
//
//        t.inorder();
//
//        System.out.println(t.contains(191));

//        Dijkstra d = new Dijkstra();
//        d.test();

//        int x = 4;
//
//        String s = "abcd";
//
//        System.out.println(s.substring(3));
//
//        Question q = new Question();
//
//        int[] list = { 1, 2, 3, 4, 5, 6, 7, 9, 10, 11 };
//        int sum = 0;
//        for (int i=0;i<list.length; i++) {
//            sum += list[i];
//            if (sum != ((i+1)*(i+2))/2){
//                System.out.println(i+1);
//                break;
//            }
//        }
//
//        BitSet b = new BitSet(100);


//        new Towers().test();

//        System.out.println((x & (1 << 2)) != 0);

    //System.out.println(Character.getNumericValue('*'));

    byte[] a = new byte[]{0, 1, 0, 1};
    byte[] b = new byte[]{1, 1, 0, 1};

        

        /*Problem p = new BinarySearchTreeIterator();
        p.run();*/


//        List<List<Integer>> l = new ArrayList<>();
//        l.add(Arrays.asList(1, 2));
//        System.out.println(l.contains(Arrays.asList(1,2)));

  }


  static void quick_sort(int[] array, int low, int high) {
    if (low < high) {
      int p = partition(array, low, high);
      quick_sort(array, low, p - 1);
      quick_sort(array, p + 1, high);
    }
  }

  static int partition(int[] array, int low, int high) {
    int i = low - 1;
    for (int j = low; j < high - 1; j++) {
      if (array[j] <= array[high]) {
        i++;
        swap(array, i, j);
      }
    }

    swap(array, i + 1, high);

    return i + 1;
  }

  static void mergeSort(int[] array) {
    int[] helper = new int[array.length];
    mergeSort(array, helper, 0, array.length - 1);
  }

  static void mergeSort(int[] array, int[] helper, int low, int high) {
    if (low < high) {
      int middle = (low + high) / 2;
      mergeSort(array, helper, low, middle);
      mergeSort(array, helper, middle + 1, high);
      merge(array, helper, low, middle, high);
    }
  }

  static void merge(int[] array, int[] helper, int low, int middle, int high) {
    for (int i = low; i <= high; i++) {
      helper[i] = array[i];
    }

    int leftArrow = low;
    int rightArrow = middle + 1;
    int current = low;

    while (leftArrow <= middle && rightArrow <= high) {
      if (helper[leftArrow] <= helper[rightArrow]) {
        array[current] = helper[leftArrow];
        leftArrow++;
      } else {
        array[current] = helper[rightArrow];
        rightArrow++;
      }
      current++;
    }

    int remaining = middle - leftArrow;
    for (int i = 0; i <= remaining; i++) {
      array[current + i] = helper[leftArrow + i];
    }

    for (int i = low; i < high; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println("");
  }

  static void swap(int[] array, int left, int right) {
    int t = array[left];
    array[left] = array[right];
    array[right] = t;
  }

  public static class Tree {
    Node root;

    public Tree() {
//            Integer.pa
    }

    public void add(int val) {
      Node n = new Node(val);
      if (root == null) {
        root = n;
      } else {
        add(root, n);
      }
    }

    public void preorder() {
      preorder(root);
      System.out.println("");
    }

    private void preorder(Node n) {
      if (n != null) {
        System.out.print(n.value + " ");
        preorder(n.left);
        preorder(n.right);
      }
    }

    public void inorder() {
      inorder(root);
      System.out.println("");
    }

    public void inorder(Node n) {
      if (n != null) {
        inorder(n.left);
        System.out.print(n.value + " ");
        inorder(n.right);
      }
    }

    public void remove(int val) {
      Node n = contains(val);
      if (n != null) {
        if (n.parent == null) {
          // root
          if (n.right != null) {
            root = n.right;
            root.left = n.left;
          } else {
            root = n.left;
          }
        } else {

        }
      }
    }

    private void add(Node p, Node n) {
      if (n.value > p.value) {
        // add right
        if (p.right == null) {
          p.right = n;
          n.parent = p;
        } else {
          add(p.right, n);
        }
      } else {
        if (p.left == null) {
          p.left = n;
          n.parent = p;
        } else {
          add(p.left, n);
        }
      }
    }

    public Node contains(int val) {
      return contains(root, val);
    }

    private Node contains(Node p, int val) {
      if (p == null) {
        return null;
      }

      if (p.value == val) {
        return p;
      } else {
        if (val < p.value) {
          return contains(p.left, val);
        } else {
          return contains(p.right, val);
        }
      }
    }

    public class Node {
      public int value;

      public Node parent;
      public Node left;
      public Node right;

      public Node(int val) {
        this.value = val;
      }
    }
  }

  static class Heap {
    private final int[] array;
    private int position = 0;
    private int size = 0;

    public Heap(int size) {
      array = new int[size];
    }

    public Heap(int[] a) {
      this.array = a;
      this.size = a.length;
      this.hipify();
    }

    public int getPosition() {
      return position;
    }

    public int[] getArray() {
      return array;
    }

    private void hipify() {
      int x = size / 2 - 1;
      while (x >= 0) {
        hipify(x);
        x--;
      }
    }

    private void hipify(int x) {
      if (x < size / 2) {
        int left = 2 * x + 1;
        int right = left + 1;

        int largest = left;
        if (right < size && array[right] > array[left]) {
          largest = right;
        }

        if (array[x] < array[largest]) {
          swap(x, largest);
          hipify(largest);
        }
      }
    }

    public void add(int value) {
      array[position++] = value;
      size++;
      trickleUp();
    }

    public void remove() {
      swap(0, position - 1);
      size--;
      trickleDown();
      position--;
    }

    public void trickleDown() {
      int idx = 0;
      while (idx < size / 2) {
        int left = idx * 2 + 1;
        int right = left + 1;

        int largerChild;
        if (right < size && array[right] > array[left]) {
          largerChild = right;
        } else {
          largerChild = left;
        }

        if (array[idx] >= array[largerChild]) {
          break;
        } else {
          swap(idx, largerChild);
          idx = largerChild;
        }
      }
    }

    private void trickleUp() {
      int x = position - 1;
      while (x > 0) {
        int parent = (x - 1) / 2;
        if (array[parent] < array[x]) {
          swap(parent, x);
          x = parent;
        } else {
          break;
        }
      }
    }

    private void print() {
      for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
      }
      System.out.println("");
    }

    private void swap(int x, int y) {
      int t = array[x];
      array[x] = array[y];
      array[y] = t;
    }
  }
}
