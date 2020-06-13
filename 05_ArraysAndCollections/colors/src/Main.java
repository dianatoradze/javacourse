public class Main {
    public static void main (String args[]) {
    String text = "Каждый охотник желает знать, где сидит фазан";
    String[] colors = text.split(",?\\s+");
        int n = colors.length;
        String reverse;

        for (int i = 0; i < n/2; i++) {
            reverse = colors[n-i-1];
            colors[n-i-1] = colors[i];
            colors[i] = reverse;
        }
            for (int i=0; i<colors.length; i++){
            System.out.print(colors[i]);
            System.out.println();
        }
    }
}
