package com.muhammedazman.navigationcompanentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.muhammedazman.navigationcompanentsample.model.Speaker
import kotlinx.android.synthetic.main.fragment_speaker_list.*

class SpeakerListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speaker_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Okan Info
        imgSpeaker.setImageResource(Speaker.getOkanInfo().image)
        tvSpeakerName.setText(Speaker.getOkanInfo().name)
        tvSpeakerTitle.setText(Speaker.getOkanInfo().title)

        // Mert Info
        imgSpeaker1.setImageResource(Speaker.getMertInfo().image)
        tvSpeakerName1.setText(Speaker.getMertInfo().name)
        tvSpeakerTitle1.setText(Speaker.getMertInfo().title)

        cardViewOkan.setOnClickListener {
            findNavController().navigate(
                SpeakerListFragmentDirections.actionSpeakerListFragmentToSpeakerDetailFragment(
                    Speaker.getOkanInfo()
                )
            )
        }

        cardViewMert.setOnClickListener {
            findNavController().navigate(
                SpeakerListFragmentDirections.actionSpeakerListFragmentToSpeakerDetailFragment(
                    Speaker.getMertInfo()
                )
            )
        }
    }
}