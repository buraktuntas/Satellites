package com.satellites.main_presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.satellites.core.util.changeDateFormat
import com.satellites.core.util.formatWithDots
import com.satellites.core_ui.components.SpaceVertical
import com.satellites.core_ui.icon.IconLoading
import com.satellites.core_ui.text.*
import com.satellites.core_ui.theme.*
import com.satellites.core_ui.util.UiText
import com.satellites.main_domain.model.response.detail.SatelliteDetailResponseItem
import com.satellites.main_domain.model.response.list.SatelliteListResponseItem

@ExperimentalPagerApi
@Composable
fun SatelliteDetailScreen(
    viewModel: SatelliteDetailViewModel = hiltViewModel(),
    satellite: SatelliteListResponseItem?
) {

    val uiState by viewModel.uiState.collectAsState()

    viewModel.updateSatelliteId(satellite)

    SatelliteDetailScreenUI(
        uiState = uiState,
    )
}

@ExperimentalPagerApi
@Composable
fun SatelliteDetailScreenUI(
    uiState: SatelliteDetailUiState,
) {
    val spacing = LocalSpacing.current
    val satellite = uiState.satellite
    val satelliteDetail = uiState.satelliteDetail
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = GreyColor)
            .padding(
                horizontal = spacing.spaceScreenHorizontalPadding,
                vertical = spacing.spaceScreenVerticalPadding
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        if (uiState.isLoading) {
            IconLoading(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
        } else {

            TextTitleXLarge(
                TextParameters(
                    modifier = Modifier
                        .wrapContentSize(),
                    text = UiText.DynamicString(satellite.name.toString()),
                )
            )
            SpaceVertical(height = spacing.spaceXSmall)
            TextBodySmall(
                color = DarkGreyColor,
                textParameters = TextParameters(
                    modifier = Modifier
                        .wrapContentSize(),
                    text = UiText.DynamicString(satelliteDetail.first_flight.changeDateFormat()),
                )
            )
            SpaceVertical(height = spacing.spaceXXXLarge)
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,

                    ) {
                    TextTitleXSmall(
                        color = BlackColor,
                        textParameters = TextParameters(
                            modifier = Modifier
                                .wrapContentSize(),
                            text = UiText.DynamicString("Height/Mass:"),
                        )
                    )
                    TextBodySmall(
                        color = BlackColor,
                        textParameters = TextParameters(
                            modifier = Modifier
                                .wrapContentSize(),
                            text = UiText.DynamicString(satelliteDetail.height.toString() + "/" + satelliteDetail.mass.toString()),
                        )
                    )
                }
                SpaceVertical(height = spacing.spaceLarge)
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,

                    ) {
                    TextTitleXSmall(
                        color = BlackColor,
                        textParameters = TextParameters(
                            modifier = Modifier
                                .wrapContentSize(),
                            text = UiText.DynamicString("Cost:"),
                        )
                    )
                    TextBodySmall(
                        color = BlackColor,
                        textParameters = TextParameters(
                            modifier = Modifier
                                .wrapContentSize(),
                            text = UiText.DynamicString(satelliteDetail.cost_per_launch.formatWithDots()),
                        )
                    )
                }
                SpaceVertical(height = spacing.spaceLarge)
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,

                    ) {
                    TextTitleXSmall(
                        color = BlackColor,
                        textParameters = TextParameters(
                            modifier = Modifier
                                .wrapContentSize(),
                            text = UiText.DynamicString("Last Position:"),
                        )
                    )
                    TextBodySmall(
                        color = BlackColor,
                        textParameters = TextParameters(
                            modifier = Modifier
                                .wrapContentSize(),
                            text = UiText.DynamicString("("+uiState.posX.toString()+","+uiState.posY.toString()+")"),
                        )
                    )
                }
            }

        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun PreviewSatelliteDetailScreenUI() {
    SatellitesTheme {
        SatelliteDetailScreenUI(
            uiState = SatelliteDetailUiState(
                satelliteDetail = SatelliteDetailResponseItem(
                    id = 1,
                    mass = 1,
                    height = 1,
                    first_flight = "",
                    cost_per_launch = 1,
                ),
                satellite = SatelliteListResponseItem(
                    id = 1,
                    active = true,
                    name = "test"

                )
            ),
        )
    }
}

