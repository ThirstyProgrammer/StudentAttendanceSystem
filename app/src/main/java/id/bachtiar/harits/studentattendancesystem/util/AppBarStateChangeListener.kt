package id.bachtiar.harits.studentattendancesystem.util

import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs

abstract class AppBarStateChangeListener: AppBarLayout.OnOffsetChangedListener {

    private var mCurrentState = State.IDLE

    enum class State{
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (verticalOffset == 0) {
            if (mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED)
            }
            mCurrentState = State.EXPANDED
        }else if (abs(verticalOffset) >= (appBarLayout?.totalScrollRange ?: 0 - 48)) {
            if (mCurrentState != State.COLLAPSED){
                onStateChanged(appBarLayout, State.COLLAPSED)
            }
            mCurrentState = State.COLLAPSED
        }
    }

    abstract fun onStateChanged(appBarLayout: AppBarLayout?, state: State)
}