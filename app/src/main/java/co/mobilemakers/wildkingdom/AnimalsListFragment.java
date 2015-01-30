package co.mobilemakers.wildkingdom;


import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import static co.mobilemakers.wildkingdom.AnimalFragment.DESCRIPTION;
import static co.mobilemakers.wildkingdom.AnimalFragment.HABITAT;
import static co.mobilemakers.wildkingdom.AnimalFragment.IMAGE_ID;
import static co.mobilemakers.wildkingdom.AnimalFragment.NAME;
/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalsListFragment extends ListFragment {

    private String[] animals = {"Brown Bear", "Grizzly Bear", "Wombat", "Gecko", "Coral Snake",
                                "Tortoise"};
    private String[] description = {"Adult bears generally weigh between 100 and 635 kg (220 and 1,400 lb). Its largest subspecies, the Kodiak bear, rivals the polar bear as the largest member of the bear family and as the largest land-based predator.",
    "Most adult female grizzlies weigh 130–200 kg (290–440 lb), while adult males weigh on average 180–360 kg (400–790 lb). Average total length in this subspecies is 198 cm (6.50 ft), with an average shoulder height of 102 cm (3.35 ft) and hindfoot length of 28 cm (11 in).",
    "Wombats are short-legged, muscular quadrupedal marsupials that are native to Australia and are approximately 1 metre (40 in) in length, with short, stubby tails. All are members of the family Vombatidae.",
    "Geckos are lizards belonging to the infraorder Gekkota, found in warm climates throughout the world. They range from 1.6 to 60 cm. Most geckos cannot blink, but they often lick their eyes to keep them clean and moist. They have a fixed lens within each iris that enlarges in darkness to let in more light.",
    "Coral snakes are a large group of elapid snakes that can be subdivided into two distinct groups, Old World coral snakes and New World coral snakes.",
    "Tortoises are a family, Testudinidae, of land-dwelling turtles in the order Testudines. Contrary to popular belief, tortoises are in fact turtles rather than part of a separate group. Like most turtles, tortoises are shielded from predators by a shell."};
    private String[] habitat = {"Northern Eurasia and North America",
                                "North America",
                                "Australia",
                                "????",
                                "Asia",
                                "????"};
    private int[] image_id = {R.drawable.brown_bear, R.drawable.grizzly_bear, R.drawable.wombat,
            R.drawable.gecko, R.drawable.coral_snake, R.drawable.tortoise};

    public AnimalsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animals_list, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1,
                        animals));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        AnimalFragment animalFragment = new AnimalFragment();
        animalFragment.setArguments(createAnimalBundle(position));
        getFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container, animalFragment).
                addToBackStack(null).
                commit();
    }

    private Bundle createAnimalBundle(int position) {
        Bundle bundle = new Bundle();
        bundle.putString(NAME, animals[position]);
        bundle.putString(DESCRIPTION, description[position]);
        bundle.putString(HABITAT,habitat[position]);
        bundle.putInt(IMAGE_ID, image_id[position]);
        return bundle;
    }
}
