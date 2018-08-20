package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView _storyTextView;
    private Button _topButton;
    private Button _bottomButton;

    private Vector<Page> _allPages;
    private Page _currentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        _storyTextView = findViewById(R.id.storyTextView);
        _topButton = findViewById(R.id.buttonTop);
        _bottomButton = findViewById(R.id.buttonBottom);

        // Create all pages and link them
        _allPages = createPages();
        _currentPage = _allPages.firstElement();

        // Init view
        updateStoryAndAnswers();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        _topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _currentPage = _currentPage.getFirstAnswerNextPage();
                updateStoryAndAnswers();
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        _bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _currentPage = _currentPage.getSecondAnswerNextPage();
                updateStoryAndAnswers();
            }
        });

    }

    private void updateStoryAndAnswers() {
        // Update story text
        _storyTextView.setText(_currentPage.getStoryTextId());

        // Test if it's the end of the story
        if (_currentPage.isEndStory()) {
            // Hide button if it is
            _topButton.setVisibility(View.GONE);
            _bottomButton.setVisibility(View.GONE);
        }
        else {
            // Update button if it's not
            _topButton.setVisibility(View.VISIBLE);
            _bottomButton.setVisibility(View.VISIBLE);
            _topButton.setText(_currentPage.getFirstAnswerId());
            _bottomButton.setText(_currentPage.getSecondAnswerId());
        }
    }

    private Vector<Page> createPages() {

        // Create all pages
        Page p1 = new Page(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2);
        Page p2 = new Page(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2);
        Page p3 = new Page(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
        Page p4 = new Page(R.string.T4_End);
        Page p5 = new Page(R.string.T5_End);
        Page p6 = new Page(R.string.T6_End);

        // Link pages
        p1.setFirstAnswerNextPage(p3);
        p1.setSecondAnswerNextPage(p2);

        p2.setFirstAnswerNextPage(p3);
        p2.setSecondAnswerNextPage(p4);

        p3.setFirstAnswerNextPage(p6);
        p3.setSecondAnswerNextPage(p5);

        // Add them to container
        Vector<Page> allPages = new Vector<>();
        allPages.add(p1);
        allPages.add(p2);
        allPages.add(p3);
        allPages.add(p4);
        allPages.add(p5);
        allPages.add(p6);

        // Return container
        return allPages;
    }
}
