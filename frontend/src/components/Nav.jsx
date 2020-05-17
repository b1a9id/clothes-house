import React from 'react';
import { Link } from 'react-router-dom'

export default function Nav() {
  return (
    <ul>
      <li><Link to="/">Closet</Link></li>
      <li><Link to="/settings">Setting</Link></li>
    </ul>
  )
}
