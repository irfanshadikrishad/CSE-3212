package io.irfanshadikrishad.assignment5

import io.irfanshadikrishad.assignment5.adapters.ItemAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.irfanshadikrishad.assignment5.models.Item

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Sample data
        val itemList = listOf(
            Item(
                "Believe in Yourself",
                "You are braver than you believe, stronger than you seem, and smarter than you think."
            ),
            Item("Dream Big", "Set your goals high, and don't stop till you get there."),
            Item("Stay Positive", "Keep your face to the sunshine, and you cannot see a shadow."),
            Item(
                "Hard Work Pays Off",
                "Success is the sum of small efforts repeated day in and day out."
            ),
            Item("Never Give Up", "It always seems impossible until it's done."),
            Item("Be Kind", "No act of kindness, no matter how small, is ever wasted."),
            Item(
                "Embrace Change", "Growth is painful, but nothing is as painful as staying stuck."
            ),
            Item("Gratitude Matters", "Gratitude turns what we have into enough."),
            Item("Courage to Begin", "The journey of a thousand miles begins with a single step."),
            Item("Time is Precious", "Don't count the days; make the days count."),
            Item("Stay Curious", "Curiosity is the wick in the candle of learning."),
            Item("Keep Learning", "An investment in knowledge pays the best interest."),
            Item(
                "Failure is a Step",
                "Failure is simply the opportunity to begin again, this time more intelligently."
            ),
            Item(
                "Think Differently",
                "Innovation is seeing what everybody has seen and thinking what nobody has thought."
            ),
            Item("Be Fearless", "Do one thing every day that scares you."),
            Item(
                "Celebrate Small Wins", "The smallest deed is better than the greatest intention."
            ),
            Item(
                "Patience is Power",
                "Rivers know this: there is no hurry, we shall get there someday."
            ),
            Item("Spread Happiness", "Happiness is not by chance, but by choice."),
            Item(
                "Live in the Moment",
                "Yesterday is history, tomorrow is a mystery, today is a gift."
            ),
            Item(
                "You Are Enough",
                "You yourself, as much as anybody in the entire universe, deserve your love and affection."
            )
        )
        val adapter = ItemAdapter(itemList) { clickedItem ->
            // Show a Toast with the title of the clicked item
            Toast.makeText(this, clickedItem.title, Toast.LENGTH_SHORT).show()
        }

        // Set up RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}