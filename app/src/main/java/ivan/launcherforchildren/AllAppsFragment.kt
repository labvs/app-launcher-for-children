package ivan.launcherforchildren

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ivan.launcherforchildren.AllAppsViewContent.AllAppsViewItem

class AllAppsFragment : Fragment() {

    private var listener: OnAllAppsFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_all_apps_list, container, false)
        val context = activity?.applicationContext
        if (context != null) {
            val items = AllAppsViewContent(context).items
            (view as RecyclerView).adapter = AllAppsViewAdapter(items, listener)
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnAllAppsFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() +
                    " must implement OnAllAppsFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnAllAppsFragmentInteractionListener {
        fun onAllAppsFragmentInteraction(allAppsViewItem: AllAppsViewItem?)
    }

}