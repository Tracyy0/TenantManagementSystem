package com.example.tenantmanagementsystem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_dashboard,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<android.view.View>(
            R.id.addTenantButton
        ).setOnClickListener {
            findNavController().navigate(
                R.id.action_dashboardFragment_to_addTenantFragment
            )
        }

        view.findViewById<android.view.View>(
            R.id.viewTenantsButton
        ).setOnClickListener {
            findNavController().navigate(
                R.id.action_dashboardFragment_to_viewTenantsFragment
            )
        }
    }
}
