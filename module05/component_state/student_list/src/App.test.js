import { render, screen } from '@testing-library/react';
import StudentInfoComponent from './StudentInfoComponent';

test('renders learn react link', () => {
  render(<StudentInfoComponent />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
