// @flow
import React, { PureComponent } from 'react';
import { requireNativeComponent, Platform } from 'react-native';

type Props = {
  placementId: string,
  style?: Object,
}

// Define native view and its props.
const FBAdChoicesIcon = requireNativeComponent('AdChoicesIcon')

export default class AdChoicesIcon extends PureComponent<Props> {
  render () {
    const { placementId, style } = this.props

    // iOS is not supported currently.
    if (Platform.OS !== 'android') {
      return null
    }

    return (
      <FBAdChoicesIcon
        style={style}
        placementId={placementId}
      />
    )
  }
}
