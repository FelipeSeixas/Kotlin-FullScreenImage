package YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC
import TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT

class FullScreen : Fragment() {
    companion object {
        val TAG = "ImageFullScreenFragment"
    }

    private val args: FullScreenArgs by navArgs()
    private lateinit var linkImage: String
    private lateinit var urlImage: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        linkImage = args.linkImage ?: ""
        urlImage = args.urlImage ?: ""
        return inflater.inflate(R.layout.fragment_image_full_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnLink = view.findViewById<Button>(R.id.b_link)
        val btnClose = view.findViewById<TextView>(R.id.b_quit)
        val detailImageZoom = view.findViewById<ImageZoomView>(R.id.imageAlertDialog)

        if (linkImage.isEmpty())
            btnLink.visibility = View.GONE

        btnLink.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(linkImage)))
        }

        btnClose.setOnClickListener {
            activity?.findNavController(R.id.nav_host_fragment)!!.popBackStack()
        }

        Glide.with(requireContext())
            .load(urlImage)
            .into(detailImageZoom)
    }

}