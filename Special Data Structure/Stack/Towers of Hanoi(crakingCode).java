
/**
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks
 * of different sizes which can slide onto any tower. The puzzle starts with disks sorted
 * disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top
 * of an even larger one). You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto the next tower.
 * (3) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 */
 // complete code : https://github.com/wzhishen/cracking-the-coding-interview/blob/master/src/chap03/Q4.java






    public static void moveTop(Tower from, Tower to) {
        if (to.disks.isEmpty() || from.disks.peek() < to.disks.peek()) {
            printfln("Move disk %d from tower %d to tower %d",
                     from.disks.peek(), from.id, to.id);
            to.disks.push(from.disks.pop());
        } else {
            printfln("Unable to move disk %d on top of smaller disk %d from tower %d to tower %d",
                     from.disks.peek(), to.disks.peek(), from.id, to.id);
        }
    }

    public static void moveDisks(int n, Tower from, Tower to, Tower buffer) {
        if (n <= 0) return;
        moveDisks(n - 1, from, buffer, to);
        moveTop(from, to);
        moveDisks(n - 1, buffer, to, from);
    }
