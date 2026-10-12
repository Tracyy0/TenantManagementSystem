package com.example.tenantmanagementsystem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ViewTenantsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_view_tenants,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val tenantsText =
            view.findViewById<TextView>(R.id.allTenantsTextView)

        val callButton =
            view.findViewById<Button>(R.id.callButton)

        val tenants = TenantRepository.tenants

        if (tenants.isEmpty()) {
            tenantsText.text = "No tenants have been added yet."
            callButton.visibility = View.GONE
        } else {
            tenantsText.text =
                tenants.mapIndexed { index, tenant ->
                    "${index + 1}. ${tenant.summary()}"
                }.joinToString("\n\n")

            callButton.visibility = View.VISIBLE

            callButton.setOnClickListener {
                val latestTenant = tenants.last()

                startActivity(
                    Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse("tel:${latestTenant.phone}")
                    )
                )
            }
        }
    }
}
