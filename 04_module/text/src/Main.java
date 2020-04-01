public class Main {
  public static void main (String[] args) {
            String text = "Nasa's next Mars rover will be called Perseverance The American space agency has a new name for the rover it will be sending to the Red Planet this summer. To date, the project has been known only by its code name - Mars 2020. From now on, it will be referred to as the Perseverance rover. The name came out of a schools competition that drew 28,000 entries. The Perseverance rover will begin the process of trying to bring rocks back to Earth for study. It will trundle through an equatorial crater, looking for the best samples it can cache for retrieval by a later mission. Scientists think this will be the best approach to establishing whether or not life has ever existed on Mars. Nasa's naming competition asked children to submit their favoured name along with a supporting 150-word essay. its final preparations for launch. This will take place between 17 July and 5 August. It's a seven-month cruise to the Red Planet. Engineers have targeted a touchdown for shortly after 20:30 GMT on Thursday, 18 February, 2021";
            String[] words = text.split( "\\.\\s+");
            for(int i=0; i<words.length; i++)
            {
                System.out.println(words[i]);
            }
  }
}


