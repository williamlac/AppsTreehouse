package br.com.williamlacerda.interactivestory.Model;

/**
 * Created by WilliamLac on 6/12/16.
 */
public class Choice {
    private String mText;
    private int mNextPage;

    public Choice (String text, int nextPage){
        mText = text;
        mNextPage = nextPage;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }
}
