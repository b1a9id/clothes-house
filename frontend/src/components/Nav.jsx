import React from 'react';
import PropTypes from 'prop-types';
import Drawer from "@material-ui/core/Drawer";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import { ListItemIcon } from "@material-ui/core";
import FavoriteRoundedIcon from "@material-ui/icons/FavoriteRounded";
import SettingsRoundedIcon from "@material-ui/icons/SettingsRounded";

export default function Nav({ onClick }) {
  return (
    <Drawer variant="permanent">
      <List style={{ width: 240 }}>
        <ListItem
          button
          key="menu-item-closet"
          onClick={() => onClick('/') }
        >
          <ListItemIcon>{<FavoriteRoundedIcon/>}</ListItemIcon>
          <ListItemText primary="Closet" />
        </ListItem>
        <ListItem
          button
          key="menu-item-setting"
          onClick={() => onClick('/settings') }
        >
          <ListItemIcon>{<SettingsRoundedIcon/>}</ListItemIcon>
          <ListItemText primary="Settings" />
        </ListItem>
      </List>
    </Drawer>
  )
}

Nav.propTypes = {
  onClick: PropTypes.func.isRequired
}
