package com.aratel.androidprofessional;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

/**
 * Definitions
 * full lifetime : means between onCreate and onDestroy handlers
 * visible lifetime : means between onStart and onStop handlers
 * active lifetime : means between onResume and onPause handlers
 */

public class StateChangeMonitoringActivity extends AppCompatActivity {

    final static String MY_FRAGMENT_TAG_LIST_CONTAINER = "detail_fragment";
    final static String MY_FRAGMENT_TAG_DETAIL = "detail_fragment";

    // Called at the start of the full lifetime
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Activity and inflate the UI.
        setContentView(R.layout.activity_state_change_monitoring);

        FragmentManager manager = getSupportFragmentManager();
        MySkeletonFragment mySkeletonFragment = (MySkeletonFragment) manager.findFragmentById(R.id.details_container);
        if (mySkeletonFragment == null) {
            if (savedInstanceState == null) {
                /**
                 * create and add fragments
                 */
                // adding fragment dynamically
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.add(R.id.list_container, new MySkeletonFragment(), MY_FRAGMENT_TAG_LIST_CONTAINER);
                fragmentTransaction.add(R.id.details_container, new MySkeletonFragment());
                fragmentTransaction.commitNow(); // Using commitNow is the preferred alternative, but is only available if the current transaction is not being added to the back stack.

                //*** removing a fragment dynamically
                //Fragment fragment = manager.findFragmentByTag(MY_FRAGMENT_TAG_DETAIL);
                //*** findFragmentByTag is more essential for interacting with fragments that don't include UI
                //Fragment fragment = manager.findFragmentById(R.id.details_container);
                //fragmentTransaction.remove(fragment);
                //fragmentTransaction.commitNow();

                //*** replace a fragment dynamically
                //fragmentTransaction.replace(R.id.details_container,new MySkeletonFragment(),MY_FRAGMENT_TAG_LIST_CONTAINER);
                //fragmentTransaction.commitNow();
            } else {
                // Get references to Fragments that have already been restored.
            }
        }


    }

    // Called before subsequent visible lifetimes
    // for an Activity process. That is, before an Activity
    // returns to being visible having previously been hidden.
    @Override
    protected void onRestart() {
        super.onRestart();

        // Load changes knowing that the Activity has already
        // been visible within this process.
    }

    // Called at the start of the visible lifetime.
    @Override
    protected void onStart() {
        super.onStart();

        // Apply any required UI change now that the Activity is visible.
        // This is where you'd typically start any processes that
        // are required to ensure your UI is appropriately populated and
        // updated.
    }

    // Called after onStart has finished, in cases where an Activity is
    // started after having last been destroyed by the runtime rather than
    // through user or programmatic action (such as the user hitting back or
    // your app calling finish().
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        // Will only be called if the Activity has been
        // killed by the system since it was last visible.
    }

    // Called at the start of the active lifetime.
    @Override
    protected void onResume() {
        super.onResume();

        // Resume any paused UI updates, threads, or processes required
        // by the Activity but suspended when it becomes inactive.
        // At this stage, your Activity is active and receiving input
        // from users actions.
    }

    // Called at the end of the active lifetime.
    @Override
    protected void onPause() {
        super.onPause();
        // Suspend UI updates, threads, or CPU intensive processes
        // that don't need to be updated when the Activity isn't
        // the active foreground Activity. Note that in multi-screen
        // mode, paused Activities may still be visible, and as such
        // should continue performing required UI updates.
    }

    // Called when appropriate to save UI state changes at the
    // end of the active lifecycle.
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate and
        // onRestoreInstanceState if the process is
        // killed and restarted by the run time. Note that
        // this handler may not be called if the runtime determines
        // that the Activity is being "permanently" terminated.
    }

    // Called at the end of the visible lifetime.
    @Override
    protected void onStop() {
        super.onStop();
        // Suspend remaining UI updates, threads, or processing
        // that aren't required when the Activity isn't visible.
        // Persist all edits or state changes as your Activity
        // may be killed at any time after onStop has
        // completed.
    }

    // Sometimes called at the end of the full lifetime.
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Clean up any resources including ending threads,
        // closing database connections etc.
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        // Application is a candidate for termination.
        if (level >= TRIM_MEMORY_COMPLETE) {
            // Release all possible resources to avoid immediate termination.
        } else if (level >= TRIM_MEMORY_MODERATE) {
            // Releasing resources now will and make your app less likely
            // to be terminated.
        } else if (level >= TRIM_MEMORY_BACKGROUND) {
            // Release resources that are easy to recover now.
        }
        // Application is no longer visible.
        else if (level >= TRIM_MEMORY_UI_HIDDEN) {
            // Your application no longer has any visible UI. Free any resources
            // associated with maintaining your UI.
        }
        // Application is running and not a candidate for termination.
        else if (level >= TRIM_MEMORY_RUNNING_CRITICAL) {
            // The system will now begin killing background processes.
            // Release non-critical resources now to prevent performance degradation
            // and reduce the chance of other apps being terminated.
        } else if (level >= TRIM_MEMORY_RUNNING_MODERATE) {
            // Release resources here to alleviate system memory pressure and
            // improve overall system performance.
        } else if (level >= TRIM_MEMORY_RUNNING_LOW) {
            // The system is beginning to feel memory pressure.
        }
    }
}
