package com.muhammedazman.navigationcompanentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.muhammedazman.navigationcompanentsample.model.Speaker
import kotlinx.android.synthetic.main.fragment_speaker_detail.*

class SpeakerDetailFragment : Fragment() {
    private val bundle: SpeakerDetailFragmentArgs by navArgs()
    private var speaker: Speaker? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speaker_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageViewSpeakerDetail.setImageResource(bundle.speaker.image)
        textViewSpeakerNameDetail.setText(bundle.speaker.name)
        textViewSpeakerTitleDetail.setText(bundle.speaker.title)
        textViewSpeakerLocationDetail.setText(bundle.speaker.location)
        textViewSpeakerDescriptionDetail.setText(bundle.speaker.description)
    }
}