// 2349 - Design a Number Container System
// https://leetcode.com/problems/design-a-number-container-system/
// February 7, 2025

class NumberContainers {
    // This map stores every index that contains that number
    // The TreeSet sorts indecies, so we can easily get the lowest one
    Map<Integer, TreeSet<Integer>> numberIndecies = new HashMap<Integer, TreeSet<Integer>>();

    // This map stores what number appears at what index
    Map<Integer, Integer> numberAtIndex = new HashMap<>();

    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        // Add new number
        if (numberIndecies.containsKey(number)) {
            // number has already appeared, so add our index
            TreeSet<Integer> currentIndecies = numberIndecies.get(number);
            currentIndecies.add(index);
            numberIndecies.put(number, currentIndecies);
        } else {
            // number is new, so add our index
            TreeSet<Integer> newIndecies = new TreeSet<>();
            newIndecies.add(index);
            numberIndecies.put(number, newIndecies);
        }

        // Update number stored at index
        if(numberAtIndex.containsKey(index)) {
            // index has been used
            int oldNumber = numberAtIndex.get(index);

            if (number != oldNumber) {
                // Go to the indecies where the old number is used and remove our updated index
                TreeSet<Integer> currentIndecies = numberIndecies.get(oldNumber);
                currentIndecies.remove(index);
                numberIndecies.put(oldNumber, currentIndecies);
            }
        } 
        numberAtIndex.put(index, number);
    }
    
    public int find(int number) {
        if (numberIndecies.containsKey(number)) {
            TreeSet<Integer> currentIndecies = numberIndecies.get(number);
            if(currentIndecies.isEmpty()) {
                return -1;
            }
            return currentIndecies.first(); // Thanks to TreeSet, this search is easy
        } else {
            return -1;
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */

/**
 * Well this one was a bit of a mess. It succeeds, though, and Speed beats 71.23%.
 * 
 * It uses 2 maps:
 *  - 1 to store what number is stored at what index
 *  - 1 to store at which indecies a given number is used (with a TreeSet for easy sorting!)
 * 
 * Therefore, all we have to do to find the lowest index of a given number is
 *  - Get the TreeSet for that number (contains the indecies it's used)
 *  - Find the lowest value of that TreeSet
 * 
 * However, STORING a number gets a bit trickier.
 *  - Update the Map with the new number at this index
 *  - Update the new number TreeSet to add the new index
 *  - If there was an old number at that index already, remove the index from the old number TreeSet
 * 
 * I have not optimized or cleaned this code- it feels like enough of a triumph to get it working
 * and to have solved the puzzle on my own without any hints
 */