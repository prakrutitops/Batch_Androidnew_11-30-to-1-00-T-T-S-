package com.example.test

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes


class IntroSliderFragment : Fragment() {

    // Variable declarations
    companion object {
        const val ARG_POSITION = "slider-position"

        //prepare all title ids arrays
        @StringRes
        val PAGE_TITLES = intArrayOf(
            R.string.discover,
            R.string.shop,
            R.string.offers,
            R.string.rewards
        )

        //prepare all subtitle ids arrays
        @StringRes
        val PAGE_TEXT = intArrayOf(
            R.string.discover_text,
            R.string.shop_text,
            R.string.offers_text,
            R.string.rewards_text
        )

        //prepare all subtitle images array
        @StringRes
        val PAGE_IMAGE = intArrayOf(
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background
        )

        //prepare all background images array
        @StringRes
        val BG_IMAGE = intArrayOf(
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background
        )

        /** use this factory method to create a new instance IntroSliderFragment
         * @return A new instance of fragment IntroSliderFragment
         */
        fun newInstance(position: Int): IntroSliderFragment {
            val fragment = IntroSliderFragment()
            val args = Bundle()
            args.putInt(ARG_POSITION, position)
            fragment.arguments = args
            return fragment
        }
    }

    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            position = requireArguments().getInt(ARG_POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro_slider, container, false)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set page background
        view.background = requireActivity().getDrawable(BG_IMAGE[position])
        val title = view.findViewById<TextView>(R.id.textView)
        val titleText = view.findViewById<TextView>(R.id.textView2)
        val imageView = view.findViewById<ImageView>(R.id.imageView)

        //set page title
        title.setText(PAGE_TITLES[position])

        //set page sub title text
        titleText.setText(PAGE_TEXT[position])

        //set page image
        imageView.setImageResource(PAGE_IMAGE[position])
    }
}