package com.thoughtworks.conference.presenter;

import com.thoughtworks.conference.model.Category;
import com.thoughtworks.conference.model.Session;
import com.thoughtworks.conference.view.TrackView;
import com.thoughtworks.conference.viewmodel.SessionViewModel;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.conference.testdata.TestDataUtil.parseDate;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TrackPresenterTest {

    private TrackPresenter trackPresenter;
    private TrackView trackView;
    private List<Session> sessions;
    private Session session1;
    private Session session2;

    @Before
    public void setup() {
        sessions = new ArrayList<>();
        session1 = new Session("Craft", "Try your hand at craft", parseDate
                ("2016-09-24T04:30:00+05:30"), parseDate("2016-09-24T05:30:00+05:30"), Category
                .BELONG, "Ballroom");
        session2 = new Session("Keynote", "By Chairman", parseDate("2016-09-24T05:30:00+05:30"),
                parseDate("2016-09-24T06:30:00+05:30"), Category.BELONG, "Prefunction area");
        sessions.add(session1);
        sessions.add(session2);
        trackView = mock(TrackView.class);
        trackPresenter = new TrackPresenter(sessions, trackView);
    }

    @Test
    public void tellViewToRenderDataFromViewModel() {
        trackPresenter.presentSessions();

        List<SessionViewModel> sessionViewModels = new ArrayList<>();
        sessionViewModels.add(new SessionViewModel(session1));
        sessionViewModels.add(new SessionViewModel(session2));
        verify(trackView).render(eq(sessionViewModels));
    }

    @Test
    public void verifyNavigateToDetail() {
        trackPresenter.selectSession(1);

        verify(trackView).navigateToSessionDetail(session2);
    }
}