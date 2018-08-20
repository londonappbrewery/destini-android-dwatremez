package com.londonappbrewery.destini;

public class Page {

    private int _storyTextId, _firstAnswerId, _secondAnswerId;
    private Page _firstAnswerNextPage;
    private Page _secondAnswerNextPage;

    public Page(int storyTextId) {
        this.setStoryTextId(storyTextId);
    }
    public Page(int storyTextId, int firstAnswerId, int secondAnswerId) {
        this.setStoryTextId(storyTextId);
        this.setFirstAnswerId(firstAnswerId);
        this.setSecondAnswerId(secondAnswerId);
    }

    public boolean isEndStory() {
        return _firstAnswerId == 0 ||
                _secondAnswerId == 0 ||
                _firstAnswerNextPage == null ||
                _secondAnswerNextPage == null;
    }

    public int getStoryTextId() {
        return _storyTextId;
    }

    public void setStoryTextId(int storyTextId) {
        _storyTextId = storyTextId;
    }

    public int getFirstAnswerId() {
        return _firstAnswerId;
    }

    public void setFirstAnswerId(int firstAnswerId) {
        _firstAnswerId = firstAnswerId;
    }

    public int getSecondAnswerId() {
        return _secondAnswerId;
    }

    public void setSecondAnswerId(int secondAnswerId) {
        _secondAnswerId = secondAnswerId;
    }

    public Page getFirstAnswerNextPage() {
        return _firstAnswerNextPage;
    }

    public void setFirstAnswerNextPage(Page firstAnswerNextPage) {
        this._firstAnswerNextPage = firstAnswerNextPage;
    }

    public Page getSecondAnswerNextPage() {
        return _secondAnswerNextPage;
    }

    public void setSecondAnswerNextPage(Page secondAnswerNextPage) {
        this._secondAnswerNextPage = secondAnswerNextPage;
    }
}
